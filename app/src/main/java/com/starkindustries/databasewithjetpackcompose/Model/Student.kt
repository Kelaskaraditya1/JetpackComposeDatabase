package com.starkindustries.databasewithjetpackcompose.Model

class Student {
    private var studentId: String = ""
    private var name: String = ""
    private var username: String = ""
    private var email: String = ""
    private var department: String = ""
    private var password: String = ""

    // Primary constructor
    constructor(
        studentId_: String,
        name_: String,
        username_: String,
        email_: String,
        department_: String,
        password_: String
    ) {
        this.studentId = studentId_
        this.name = name_
        this.username = username_
        this.email = email_
        this.department = department_
        this.password = password_
    }

    // Secondary constructor without password
    constructor(
        studentId_: String,
        name_: String,
        username_: String,
        email_: String,
        department_: String
    ) {
        this.studentId = studentId_
        this.name = name_
        this.username = username_
        this.email = email_
        this.department = department_
    }

    // Empty constructor
    constructor()

    // Getters and setters
    fun getStudentId(): String {
        return studentId
    }

    fun setStudentId(studentId: String) {
        this.studentId = studentId
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getUsername(): String {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getDepartment(): String {
        return department
    }

    fun setDepartment(department: String) {
        this.department = department
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    override fun toString(): String {
        return "Student(studentId='$studentId', name='$name', username='$username', email='$email', department='$department', password='$password')"
    }
}
