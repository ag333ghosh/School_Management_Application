package School.School_micro.Service;

import School.School_micro.Entity.Schools;

import java.util.List;

public interface SchoolService {
    public Schools saveSchool(Schools school);

    public List<Schools> getAllSchools();


    public Schools getSchoolById(int id);

    public Schools updateSchool(int id,Schools school);

    public void deleteSchool(int id);



}
