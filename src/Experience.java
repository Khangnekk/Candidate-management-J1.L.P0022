/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zed25
 */
public class Experience extends Candidate{
    
    private int yearExperience;
    private String proSkill;   
    

    public Experience(int yearExperience, String proSkill, String id, String firstName, String lastName,
            int birthDate, String address, String phone, String email, int candidateType) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.yearExperience = yearExperience;
        this.proSkill = proSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
    
    
    
    
}
