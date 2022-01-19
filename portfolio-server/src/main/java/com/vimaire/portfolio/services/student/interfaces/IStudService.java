package com.vimaire.portfolio.services.student.interfaces;

import com.vimaire.portfolio.models.student.Student;
import com.vimaire.portfolio.models.student.StudentFilter;
import com.vimaire.portfolio.services.generic.interfaces.IAbstractIdentifierFilterService;

public interface IStudService extends IAbstractIdentifierFilterService<Student, StudentFilter> {
}
