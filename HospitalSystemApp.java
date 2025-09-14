import java.time.LocalDate;
import java.util.*;

// ------------------ Immutable MedicalRecord ------------------
final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory,
                         LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null || birthDate == null || bloodType == null) {
            throw new IllegalArgumentException("Invalid medical data. HIPAA compliance violation.");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = Arrays.copyOf(allergies, allergies.length);
        this.medicalHistory = Arrays.copyOf(medicalHistory, medicalHistory.length);
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPatientDNA() {
        return patientDNA;
    }

    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }

    public String[] getMedicalHistory() {
        return Arrays.copyOf(medicalHistory, medicalHistory.length);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord{recordId='" + recordId + "', bloodType='" + bloodType + "'}";
    }
}

// ------------------ Patient ------------------
class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    Patient(String patientId, MedicalRecord medicalRecord) {
        if (patientId == null || medicalRecord == null)
            throw new IllegalArgumentException("Patient ID and MedicalRecord required.");
        this.patientId = patientId;
        this.medicalRecord = medicalRecord;
    }

    // Emergency admission
    public Patient(String currentName) {
        this("TEMP" + System.currentTimeMillis(), new MedicalRecord(
                "AUTO" + System.nanoTime(),
                "UNKNOWN",
                new String[]{},
                new String[]{},
                LocalDate.of(1900, 1, 1),
                "UNKNOWN"
        ));
        this.currentName = currentName;
    }

    // Standard admission
    public Patient(String patientId, MedicalRecord medicalRecord,
                   String currentName, String emergencyContact, String insuranceInfo,
                   int roomNumber, String attendingPhysician) {
        this(patientId, medicalRecord);
        this.currentName = currentName;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = attendingPhysician;
    }

    // Transfer admission
    public Patient(Patient existingPatient) {
        this(existingPatient.patientId, existingPatient.medicalRecord);
        this.currentName = existingPatient.currentName;
        this.emergencyContact = existingPatient.emergencyContact;
        this.insuranceInfo = existingPatient.insuranceInfo;
        this.roomNumber = existingPatient.roomNumber;
        this.attendingPhysician = existingPatient.attendingPhysician;
    }

    public String getPatientId() {
        return patientId;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }

    String getBasicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber + ", Physician: " + attendingPhysician;
    }

    public String getPublicInfo() {
        return "Name: " + currentName + ", Room: " + roomNumber;
    }

    @Override
    public String toString() {
        return "Patient{id='" + patientId + "', name='" + currentName + "', room=" + roomNumber + "}";
    }
}

// ------------------ Doctor ------------------
class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certifications) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = Set.copyOf(certifications);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Set<String> getCertifications() {
        return certifications;
    }

    @Override
    public String toString() {
        return "Doctor{license='" + licenseNumber + "', specialty='" + specialty + "'}";
    }
}

// ------------------ Nurse ------------------
class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = List.copyOf(qualifications);
    }

    public String getNurseId() {
        return nurseId;
    }

    public String getShift() {
        return shift;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    @Override
    public String toString() {
        return "Nurse{id='" + nurseId + "', shift='" + shift + "'}";
    }
}

// ------------------ Administrator ------------------
class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = List.copyOf(accessPermissions);
    }

    public String getAdminId() {
        return adminId;
    }

    public List<String> getAccessPermissions() {
        return accessPermissions;
    }

    @Override
    public String toString() {
        return "Admin{id='" + adminId + "', permissions=" + accessPermissions + "}";
    }
}

// ------------------ HospitalSystem ------------------
class HospitalSystem {
    private final Map<String, Object> patientRegistry = new HashMap<>();

    public static final String PRIVACY_POLICY = "HIPAA_COMPLIANT";
    public static final int MAX_PATIENTS = 1000;

    public boolean admitPatient(Object patient, Object staff) {
        if (!(patient instanceof Patient)) return false;
        if (!validateStaffAccess(staff, patient)) return false;
        Patient p = (Patient) patient;
        patientRegistry.put(p.getPatientId(), p);
        return true;
    }

    private boolean validateStaffAccess(Object staff, Object patient) {
        if (staff instanceof Doctor || staff instanceof Administrator) {
            return true; // Full access
        } else if (staff instanceof Nurse) {
            return patient instanceof Patient; // Limited access
        }
        return false;
    }

    void transferPatient(String patientId, int newRoom) {
        Patient patient = (Patient) patientRegistry.get(patientId);
        if (patient != null) {
            patient.setRoomNumber(newRoom);
        }
    }

    void dischargePatient(String patientId) {
        patientRegistry.remove(patientId);
    }

    @Override
    public String toString() {
        return "HospitalSystem{patients=" + patientRegistry.keySet() + "}";
    }
}

// ------------------ Demo Main ------------------
public class HospitalSystemApp {
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();

        MedicalRecord record = new MedicalRecord(
                "REC001", "DNA123", new String[]{"Peanuts"}, new String[]{"Asthma"},
                LocalDate.of(1990, 5, 15), "O+"
        );

        Patient patient = new Patient("PAT001", record, "John Doe", "Jane Doe",
                "XYZ Insurance", 101, "Dr. House");

        Doctor doctor = new Doctor("DOC123", "Cardiology", Set.of("Board Certified"));
        Nurse nurse = new Nurse("NUR456", "Night", List.of("BSN", "CPR"));
        Administrator admin = new Administrator("ADM789", List.of("READ", "WRITE", "DELETE"));

        system.admitPatient
