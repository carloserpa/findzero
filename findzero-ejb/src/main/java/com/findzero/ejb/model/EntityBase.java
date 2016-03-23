package com.findzero.ejb.model;

import java.io.Serializable;

/**
 * Classe básica para criação das Entity's.
 */
public interface EntityBase {
  /**
   * @return o Id da Entity.
   */
  public Serializable getId();
}