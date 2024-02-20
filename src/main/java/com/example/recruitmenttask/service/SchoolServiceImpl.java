package com.example.recruitmenttask.service;

import com.example.recruitmenttask.model.Attendance;
import com.example.recruitmenttask.model.Child;
import com.example.recruitmenttask.model.Parent;
import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.model.projection.MonthlyChildSettlement;
import com.example.recruitmenttask.model.projection.MonthlyParentSettlement;
import com.example.recruitmenttask.model.projection.MonthlySchoolSettlement;
import com.example.recruitmenttask.repository.AttendanceRepo;
import com.example.recruitmenttask.repository.ChildRepo;
import com.example.recruitmenttask.repository.ParentRepo;
import com.example.recruitmenttask.repository.SchoolRepo;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepo schoolRepo;
    private final ChildRepo childRepo;
    private final AttendanceRepo attendanceRepo;
    private final ParentRepo parentRepo;

    public SchoolServiceImpl(SchoolRepo schoolRepo, ChildRepo childRepo, AttendanceRepo attendanceRepo, ParentRepo parentRepo) {
        this.schoolRepo = schoolRepo;
        this.childRepo = childRepo;
        this.attendanceRepo = attendanceRepo;
        this.parentRepo = parentRepo;
    }

    public void saveSchool(School school) {
        schoolRepo.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    public School getSchoolById(Integer id) {
        return schoolRepo.findById(id).orElse(null);
    }

    @Override
    public MonthlySchoolSettlement getSchoolSettlementByMonth(Integer id, int month) {
        School school = schoolRepo.findById(id).orElse(null);
        List<Attendance> attendancesInSchool = attendanceRepo.findAllByChildIds(childRepo.findIdsBySchoolId(id))
                .stream()
                .flatMap(Collection::stream)
                .filter(x -> x.getEntry_date().getMonth().equals(Month.of(month)))
                .toList();

        int paidHours = calculatePaidHours(attendancesInSchool);
        return new MonthlySchoolSettlement(school.getName(), Month.of(month).name(), school.getHour_price() * (float) paidHours);
    }

    @Override
    public MonthlyParentSettlement getParentSettlementByMonth(Integer id, int month, Integer parentId) {
        School school = schoolRepo.findById(id).orElse(null);
        Parent parent = parentRepo.findById(id).orElse(null);
        List<Child> children = childRepo.findAllByParentId(parentId);
        List<MonthlyChildSettlement> childrenList = new ArrayList<>();
        for (Child c : children) {
            childrenList.add(getChildSettlement(c, school, month));
        }
        float totalSum = (float) childrenList.stream().mapToDouble(MonthlyChildSettlement::getTotalSum).sum();
        return new MonthlyParentSettlement(parent.getFirstname(), parent.getLastname(), childrenList, totalSum);
    }

    private MonthlyChildSettlement getChildSettlement(Child child, School school, int month) {
        List<Attendance> attendancesInSchool = attendanceRepo.findAllByChildIds(List.of(child.getId()))
                .stream()
                .flatMap(Collection::stream)
                .filter(x -> x.getEntry_date().getMonth().equals(Month.of(month)))
                .toList();
        int totalTime = 0;
        for (Attendance a : attendancesInSchool) {
            totalTime += a.getExit_date().getHour() - a.getEntry_date().getHour();
        }
        float totalSum = calculatePaidHours(attendancesInSchool) * school.getHour_price();
        return new MonthlyChildSettlement(child.getFirstname(), school.getName(), totalTime, totalSum);
    }

    private int calculatePaidHours(List<Attendance> attendances) {
        int paidHours = 0;
        for (Attendance a : attendances) {
            int entryHour = a.getEntry_date().getHour();
            int exitHour = a.getExit_date().getHour();
            if (entryHour >= 12 && a.getEntry_date().getMinute() > 0) {
                if (entryHour == exitHour) {
                    paidHours += 1;
                } else {
                    paidHours += exitHour - entryHour;
                }
            } else if (entryHour < 7) {
                if (entryHour == exitHour) {
                    paidHours += 1;
                } else {
                    if (exitHour >= 12 && a.getExit_date().getMinute() > 1) {
                        if (exitHour == 12) {
                            paidHours += 1;
                        } else {
                            paidHours += exitHour - 12;
                        }
                        paidHours += 7 - entryHour;
                    } else if (exitHour < 7) {
                        paidHours += exitHour - entryHour;
                    } else {
                        paidHours += 7 - entryHour;
                    }
                }
            } else {
                if (exitHour >= 12 && a.getExit_date().getMinute() > 1) {
                    if (exitHour == 12) paidHours += 1;
                    else paidHours += exitHour - 12;
                }
            }
        }
        return paidHours;
    }
}
