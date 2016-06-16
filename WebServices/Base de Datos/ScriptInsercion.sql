INSERT INTO `sistemaprestamos`.`dispositivo` (`codigo`, `descripcion`, 
    `tipo`, `marca`, `valor`, `estado`, `observacion`, `fechaAdquisicion`, `eliminado`, `fechaEliminacion`, `administradorElimina`) 
VALUES ('1', NULL, 'Computador', NULL, NULL, 'DISPONIBLE', NULL, NULL, NULL, NULL, NULL);

INSERT INTO `sistemaprestamos`.`rol` (`codigo`, `nombre`) VALUES ('1', 'ADMINISTRADOR');

INSERT INTO `sistemaprestamos`.`rol` (`codigo`, `nombre`) VALUES ('2', 'INVESTIGADOR');

INSERT INTO `sistemaprestamos`.`usuario` (`usuario`, `contrasena`, `numeroDocumento`, `nombres`, `apellidos`, `rol`, `fechaSancion`) 
VALUES ('root', 'root', '4213', 'Root', 'Root', '1', NULL);

INSERT INTO `sistemaprestamos`.`usuario` (`usuario`, `contrasena`, `numeroDocumento`, `nombres`, `apellidos`, `rol`, `fechaSancion`) 
VALUES ('user', 'user', '232323', 'User', 'User', '2', NULL);