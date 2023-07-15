create database ols; USE ols;

-- User table
CREATE TABLE User (
  UserID INT PRIMARY KEY AUTO_INCREMENT,
  Name NVARCHAR(255) NOT NULL,
  Email NVARCHAR(255) NOT NULL unique,
  Password NVARCHAR(255) NOT NULL,
  Role NVARCHAR(255) NOT NULL,
  Status bit not null,
  CONSTRAINT CHK_Role CHECK (Role IN ('Customer', 'Expert', 'Admin'))
);

-- Subject table
CREATE TABLE Categories (
  CategoryID INT PRIMARY KEY AUTO_INCREMENT,
  Name NVARCHAR(255) NOT NULL unique
);

-- Course table
CREATE TABLE Course (
  CourseID INT PRIMARY KEY AUTO_INCREMENT,
  Title NVARCHAR(255) NOT NULL,
  Thumbnail text,
  Description text,
  CategoryID INT,
  FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Registration table
CREATE TABLE Registration (
  RegistrationID INT PRIMARY KEY AUTO_INCREMENT,
  CourseID INT,
  UserID INT,
  RegistrationDate DATE,
  EndDate DATE,
  Status bit,
  -- Other relevant attributes
  FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
  FOREIGN KEY (UserID) REFERENCES `User`(UserID)
);

-- Test table
CREATE TABLE Test (
  TestID INT PRIMARY KEY AUTO_INCREMENT,
  CourseID INT,
  Title NVARCHAR(255) NOT NULL,
  Duration INT not null,
  Type nvarchar(255) not null,
  CONSTRAINT CHK_TestType CHECK (Type IN ('small', 'midterm', 'final')),
  FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

-- TestResult table
CREATE TABLE TestResult (
  ResultID INT PRIMARY KEY AUTO_INCREMENT,
  TestID INT,
  UserID INT,
  Score INT,
  TestDate DATE,
  FOREIGN KEY (TestID) REFERENCES Test(TestID),
  FOREIGN KEY (UserID) REFERENCES `User`(UserID)
);

-- QuestionBank table
CREATE TABLE QuestionBank (
  QuestionID INT PRIMARY KEY AUTO_INCREMENT,
  TestID INT,
  QuestionText NVARCHAR(255) NOT NULL,
  A nvarchar(255) NOT NULL, B nvarchar(255) NOT NULL, C nvarchar(255) NOT NULL, D nvarchar(255) NOT NULL,
  CorrectAnswer NVARCHAR(1) NOT NULL,
  FOREIGN KEY (TestID) REFERENCES Test(TestID)
);

-- UserAnswer table
CREATE TABLE UserAnswer (
  UserAnswerID INT PRIMARY KEY AUTO_INCREMENT,
  ResultID INT,
  QuestionID INT,
  SelectedAnswer NVARCHAR(255),
  FOREIGN KEY (ResultID) REFERENCES TestResult(ResultID),
  FOREIGN KEY (QuestionID) REFERENCES QuestionBank(QuestionID)
);

-- Lesson table
CREATE TABLE Lesson (
  LessonID INT PRIMARY KEY AUTO_INCREMENT,
  CourseID INT,
  Title NVARCHAR(255) NOT NULL,
  Content TEXT,
  Video text,
  Resource text,
  FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

CREATE TABLE CourseExpert (
  CourseExpertID INT PRIMARY KEY AUTO_INCREMENT,
  CourseID INT,
  UserID INT,
  CONSTRAINT UC_CourseExpert UNIQUE (CourseID, UserID),
  FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
  FOREIGN KEY (UserID) REFERENCES User(UserID),
  CONSTRAINT FK_ExpertUser FOREIGN KEY (UserID) 
    REFERENCES User(UserID) 
    ON DELETE CASCADE
);

-- Trigger to Check Assign User to a course is an expert
DELIMITER //
CREATE TRIGGER trg_CourseExpert_CheckExpert
BEFORE INSERT ON CourseExpert
FOR EACH ROW
BEGIN
    DECLARE expertCount INT;
    -- Check if the user with the given UserID is an expert
    SELECT COUNT(*) INTO expertCount
    FROM User
    WHERE UserID = NEW.UserID AND Role = 'Expert';
    -- If the user is not an expert, raise an error and cancel the insertion
    IF expertCount = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Only expert users can be associated with a course.';
    END IF;
END //
DELIMITER ;

-- schedule to update the registration status everyday
CREATE EVENT evt_UpdateRegistrationStatus
ON SCHEDULE EVERY 1 day
DO
    UPDATE Registration
    SET Status = 'false'
    WHERE EndDate < CURDATE();




