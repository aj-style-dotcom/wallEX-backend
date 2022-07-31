package com.codelancer.WallEX.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class WallModel {
    @Id
    String id;
    String name;
    String type;
    @Lob
    byte[] data;
}
