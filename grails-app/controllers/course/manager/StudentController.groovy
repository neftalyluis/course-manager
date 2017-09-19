/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.manager

/**
 *
 * @author neftaly
 */
class StudentController {
    
    def studentService
    
    def index() {
        [students: studentService.getAll()]
    }
    
    def checkStudent() {
        []
    }
    
    def crear() {
        []
    }
}

