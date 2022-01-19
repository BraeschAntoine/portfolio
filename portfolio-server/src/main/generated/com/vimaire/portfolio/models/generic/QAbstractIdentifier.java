package com.vimaire.portfolio.models.generic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractIdentifier is a Querydsl query type for AbstractIdentifier
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAbstractIdentifier extends EntityPathBase<AbstractIdentifier> {

    private static final long serialVersionUID = 941595130L;

    public static final QAbstractIdentifier abstractIdentifier = new QAbstractIdentifier("abstractIdentifier");

    public final NumberPath<Long> identifier = createNumber("identifier", Long.class);

    public final StringPath uuid = createString("uuid");

    public QAbstractIdentifier(String variable) {
        super(AbstractIdentifier.class, forVariable(variable));
    }

    public QAbstractIdentifier(Path<? extends AbstractIdentifier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractIdentifier(PathMetadata metadata) {
        super(AbstractIdentifier.class, metadata);
    }

}

