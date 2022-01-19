package com.vimaire.portfolio.models.student;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 1083872880L;

    public static final QStudent student = new QStudent("student");

    public final com.vimaire.portfolio.models.generic.QAbstractIdentifier _super = new com.vimaire.portfolio.models.generic.QAbstractIdentifier(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DateTimePath<java.time.Instant> dob = createDateTime("dob", java.time.Instant.class);

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> identifier = _super.identifier;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath uuid = _super.uuid;

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

