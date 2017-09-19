/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package course.manager

import grails.transaction.Transactional

/**
 *
 * @author neftaly
 */
@Transactional
class StudentService {
    def getAll() {
        return Student.list()
    }
    
    def findById(Long id) {
        return Student.find(id)
    }
    
    def findByUsername(String username) {
        return Student.findByUsername(username)
    }
}

