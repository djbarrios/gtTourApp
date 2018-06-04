package data;

import java.util.ArrayList;
import java.util.List;

public class generalInfo {
    public List<department>  getDepartments(){
        department _department;
        List<department> departmentsList = new ArrayList<>();

        _department = new department(1,"Guatemala");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(2,"El Progreso");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(3,"Sacatepéquez");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(4,"Chimaltenango");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(5,"Escuintla");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(6,"Santa Rosa");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(7,"Sololá");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(8,"Totonicapán");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(9,"Quetzaltenango");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(10,"Suchitepéquez");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(11,"Retalhuleu");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(12,"San Marcos");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(13,"Huehuetenango");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(14,"Quiché");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(15,"Baja Verapaz");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(16,"Alta Verapaz");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(17,"Petén");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(18,"Izabal");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(19,"Zacapa");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(20,"Chiquimula");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(21,"Jalapa");
        this.fillTownships(_department);
        departmentsList.add(_department);

        _department = new department(22,"Jutiapa");
        this.fillTownships(_department);
        departmentsList.add(_department);
        return departmentsList;
    }

    private void fillTownships(department department){
        //Agrega los municipios en base al ID del departamento
        switch (department.getDepartmentId()) {
            case 1:
                department.addTownship(new township(1, "Guatemala"));
                department.addTownship(new township(2, "Santa Catarina Pinula"));
                department.addTownship(new township(3, "San José Pinula"));
                department.addTownship(new township(4, "San José del Golfo"));
                department.addTownship(new township(5, "Palencia"));
                department.addTownship(new township(6, "Chinautla"));
                department.addTownship(new township(7, "San Pedro Ayampuc"));
                department.addTownship(new township(8, "Mixco"));
                department.addTownship(new township(9, "San Pedro Sacatepéquez"));
                department.addTownship(new township(10, "San Juan Sacatepéquez"));
                department.addTownship(new township(11, "San Raymundo"));
                department.addTownship(new township(12, "Chuarrancho"));
                department.addTownship(new township(13, "Fraijanes"));
                department.addTownship(new township(14, "Amatitlán"));
                department.addTownship(new township(15, "Villa Nueva"));
                department.addTownship(new township(16, "Villa Canales"));
                department.addTownship(new township(17, "Petapa"));
                break;
            case 2:
                department.addTownship(new township(18, "Guastatoya"));
                department.addTownship(new township(19, "Morazán"));
                department.addTownship(new township(20, "San Agustín Acasaguastlán"));
                department.addTownship(new township(21, "San Cristóbal Acasaguastlán"));
                department.addTownship(new township(22, "El Jícaro"));
                department.addTownship(new township(23, "Sansare"));
                department.addTownship(new township(24, "Sanarate"));
                department.addTownship(new township(25, "San Antonio la Paz"));
                break;
            case 3:
                department.addTownship(new township(26, "Antigua Guatemala"));
                department.addTownship(new township(27, "Jocotenango"));
                department.addTownship(new township(28, "Pastores"));
                department.addTownship(new township(29, "Sumpango"));
                department.addTownship(new township(30, "Santo Domingo Xenacoj"));
                department.addTownship(new township(31, "Santiago Sacatepéquez"));
                department.addTownship(new township(32, "San Bartolomé Milpas Altas"));
                department.addTownship(new township(33, "San Lucas Sacatepéquez"));
                department.addTownship(new township(34, "Santa Lucía Milpas Altas"));
                department.addTownship(new township(35, "Magdalena Milpas Altas"));
                department.addTownship(new township(36, "Santa María de Jesús"));
                department.addTownship(new township(37, "Ciudad Vieja"));
                department.addTownship(new township(38, "San Miguel Dueñas"));
                department.addTownship(new township(39, "Alotenango"));
                department.addTownship(new township(40, "San Antonio Aguas Calientes"));
                department.addTownship(new township(41, "Santa Catarina Barahona"));
                break;
            case 4:
                department.addTownship(new township(42, "Chimaltenango"));
                department.addTownship(new township(43, "San José Poaquil"));
                department.addTownship(new township(44, "San Martín Jilotepeque"));
                department.addTownship(new township(45, "Comalapa"));
                department.addTownship(new township(46, "Santa Apolonia"));
                department.addTownship(new township(47, "Tecpán Guatemala"));
                department.addTownship(new township(48, "Patzún"));
                department.addTownship(new township(49, "Pochuta"));
                department.addTownship(new township(50, "Patzicía"));
                department.addTownship(new township(51, "Santa Cruz Balanyá"));
                department.addTownship(new township(52, "Acatenango"));
                department.addTownship(new township(53, "Yepocapa"));
                department.addTownship(new township(54, "San Andrés Itzapa"));
                department.addTownship(new township(55, "Parramos"));
                department.addTownship(new township(56, "Zaragoza"));
                department.addTownship(new township(57, "El Tejar"));
                break;
            case 5:
                department.addTownship(new township(58, "Escuintla"));
                department.addTownship(new township(59, "Santa Lucía Cotzumalguapa"));
                department.addTownship(new township(60, "La Democracia"));
                department.addTownship(new township(61, "Siquinalá"));
                department.addTownship(new township(62, "Masagua"));
                department.addTownship(new township(63, "Tiquisate"));
                department.addTownship(new township(64, "La Gomera"));
                department.addTownship(new township(65, "Guanagazapa"));
                department.addTownship(new township(66, "San José"));
                department.addTownship(new township(67, "Iztapa"));
                department.addTownship(new township(68, "Palín"));
                department.addTownship(new township(69, "San Vicente Pacaya"));
                department.addTownship(new township(70, "Nueva Concepción"));
                break;
            case 6:
                department.addTownship(new township(71, "Cuilapa"));
                department.addTownship(new township(72, "Barberena"));
                department.addTownship(new township(73, "Santa Rosa de Lima"));
                department.addTownship(new township(74, "Casillas"));
                department.addTownship(new township(75, "San Rafael las Flores"));
                department.addTownship(new township(76, "Oratorio"));
                department.addTownship(new township(77, "San Juan Tecuaco"));
                department.addTownship(new township(78, "Chiquimulilla"));
                department.addTownship(new township(79, "Taxisco"));
                department.addTownship(new township(80, "Santa María Ixhuatán"));
                department.addTownship(new township(81, "Guazacapán"));
                department.addTownship(new township(82, "Santa Cruz Naranjo"));
                department.addTownship(new township(83, "Pueblo Nuevo Viñas"));
                department.addTownship(new township(84, "Nueva Santa Rosa"));
                break;
            case 7:
                department.addTownship(new township(85, "Sololá"));
                department.addTownship(new township(86, "San José Chacayá"));
                department.addTownship(new township(87, "Santa María Visitación"));
                department.addTownship(new township(88, "Santa Lucía Utatlán"));
                department.addTownship(new township(89, "Nahualá"));
                department.addTownship(new township(90, "Santa Catarina Ixtahuacán"));
                department.addTownship(new township(91, "Santa Clara la Laguna"));
                department.addTownship(new township(92, "Concepción"));
                department.addTownship(new township(93, "San Andrés Semetabaj"));
                department.addTownship(new township(94, "Panajachel"));
                department.addTownship(new township(95, "Santa Catarina Palopó"));
                department.addTownship(new township(96, "San Antonio Palopó"));
                department.addTownship(new township(97, "San Lucas Tolimán"));
                department.addTownship(new township(98, "Santa Cruz la Laguna"));
                department.addTownship(new township(99, "San Pablo la Laguna"));
                department.addTownship(new township(100, "San Marcos la Laguna"));
                department.addTownship(new township(101, "San Juan la Laguna"));
                department.addTownship(new township(102, "San Pedro la Laguna"));
                department.addTownship(new township(103, "Santiago Atitlán"));
                break;
            case 8:
                department.addTownship(new township(104, "Totonicapán"));
                department.addTownship(new township(105, "San Cristóbal Totonicapán"));
                department.addTownship(new township(106, "San Francisco el Alto"));
                department.addTownship(new township(107, "San Andrés Xecul"));
                department.addTownship(new township(108, "Momostenango"));
                department.addTownship(new township(109, "Santa María Chiquimula"));
                department.addTownship(new township(110, "Santa Lucía la Reforma"));
                department.addTownship(new township(111, "San Bartolo"));
                break;
            case 9:
                department.addTownship(new township(112, "Quetzaltenango"));
                department.addTownship(new township(113, "Salcajá"));
                department.addTownship(new township(114, "Olintepeque"));
                department.addTownship(new township(115, "San Carlos Sija"));
                department.addTownship(new township(116, "Sibilia"));
                department.addTownship(new township(117, "Cabricán"));
                department.addTownship(new township(118, "Cajolá"));
                department.addTownship(new township(119, "San Miguel Siguilá"));
                department.addTownship(new township(120, "Ostuncalco"));
                department.addTownship(new township(121, "San Mateo"));
                department.addTownship(new township(122, "Concepción Chiquirichapa"));
                department.addTownship(new township(123, "San Martín Sacatepéquez"));
                department.addTownship(new township(124, "Almolonga"));
                department.addTownship(new township(125, "Cantel"));
                department.addTownship(new township(126, "Huitán"));
                department.addTownship(new township(127, "Zunil"));
                department.addTownship(new township(128, "Colomba"));
                department.addTownship(new township(129, "San Francisco la Unión"));
                department.addTownship(new township(130, "El Palmar"));
                department.addTownship(new township(131, "Coatepeque"));
                department.addTownship(new township(132, "Génova"));
                department.addTownship(new township(133, "Flores Costa Cuca"));
                department.addTownship(new township(134, "La Esperanza"));
                department.addTownship(new township(135, "Palestina de los Altos"));
                break;
            case 10:
                department.addTownship(new township(136, "Mazatenango"));
                department.addTownship(new township(137, "Cuyotenango"));
                department.addTownship(new township(138, "San Francisco Zapotitlán"));
                department.addTownship(new township(139, "San Bernardino"));
                department.addTownship(new township(140, "San José el Idolo"));
                department.addTownship(new township(141, "Santo Domingo Suchitepéquez"));
                department.addTownship(new township(142, "San Lorenzo"));
                department.addTownship(new township(143, "Samayac"));
                department.addTownship(new township(144, "San Pablo Jocopilas"));
                department.addTownship(new township(145, "San Antonio Suchitepéquez"));
                department.addTownship(new township(146, "San Miguel Panán"));
                department.addTownship(new township(147, "San Gabriel"));
                department.addTownship(new township(148, "Chicacao"));
                department.addTownship(new township(149, "Patulul"));
                department.addTownship(new township(150, "Santa Bárbara"));
                department.addTownship(new township(151, "San Juan Bautista"));
                department.addTownship(new township(152, "Santo Tomás la Unión"));
                department.addTownship(new township(153, "Zunilito"));
                department.addTownship(new township(154, "Pueblo Nuevo"));
                department.addTownship(new township(155, "Río Bravo"));
                department.addTownship(new township(156, "San José La Máquina"));
                break;
            case 11:
                department.addTownship(new township(157, "Retalhuleu"));
                department.addTownship(new township(158, "San Sebastián"));
                department.addTownship(new township(159, "Santa Cruz Muluá"));
                department.addTownship(new township(160, "San Martín Zapotitlán"));
                department.addTownship(new township(161, "San Felipe"));
                department.addTownship(new township(162, "San Andrés Villa Seca"));
                department.addTownship(new township(163, "Champerico"));
                department.addTownship(new township(164, "Nuevo San Carlos"));
                department.addTownship(new township(165, "El Asintal"));
                break;
            case 12:
                department.addTownship(new township(166, "San Marcos"));
                department.addTownship(new township(167, "San Pedro Sacatepéquez"));
                department.addTownship(new township(168, "San Antonio Sacatepéquez"));
                department.addTownship(new township(169, "Comitancillo"));
                department.addTownship(new township(170, "San Miguel Ixtahuacán"));
                department.addTownship(new township(171, "Concepción Tutuapa"));
                department.addTownship(new township(172, "Tacaná"));
                department.addTownship(new township(173, "Sibinal"));
                department.addTownship(new township(174, "Tajumulco"));
                department.addTownship(new township(175, "Tejutla"));
                department.addTownship(new township(176, "San Rafael Pié de la Cuesta"));
                department.addTownship(new township(177, "Nuevo Progreso"));
                department.addTownship(new township(178, "El Tumbador"));
                department.addTownship(new township(179, "El Rodeo"));
                department.addTownship(new township(180, "Malacatán"));
                department.addTownship(new township(181, "Catarina"));
                department.addTownship(new township(182, "Ayutla"));
                department.addTownship(new township(183, "Ocós"));
                department.addTownship(new township(184, "San Pablo"));
                department.addTownship(new township(185, "El Quetzal"));
                department.addTownship(new township(186, "La Reforma"));
                department.addTownship(new township(187, "Pajapita"));
                department.addTownship(new township(188, "Ixchiguán"));
                department.addTownship(new township(189, "San José Ojetenán"));
                department.addTownship(new township(190, "San Cristóbal Cucho"));
                department.addTownship(new township(191, "Sipacapa"));
                department.addTownship(new township(192, "Esquipulas Palo Gordo"));
                department.addTownship(new township(193, "Río Blanco"));
                department.addTownship(new township(194, "San Lorenzo"));
                department.addTownship(new township(195, "La Blanca"));
                break;
            case 13:
                department.addTownship(new township(196, "Huehuetenango"));
                department.addTownship(new township(197, "Chiantla"));
                department.addTownship(new township(198, "Malacatancito"));
                department.addTownship(new township(199, "Cuilco"));
                department.addTownship(new township(200, "Nentón"));
                department.addTownship(new township(201, "San Pedro Necta"));
                department.addTownship(new township(202, "Jacaltenango"));
                department.addTownship(new township(203, "Soloma"));
                department.addTownship(new township(204, "Ixtahuacán"));
                department.addTownship(new township(205, "Santa Bárbara"));
                department.addTownship(new township(206, "La Libertad"));
                department.addTownship(new township(207, "La Democracia"));
                department.addTownship(new township(208, "San Miguel Acatán"));
                department.addTownship(new township(209, "San Rafael la Independencia"));
                department.addTownship(new township(210, "Todos Santos Cuchumatán"));
                department.addTownship(new township(211, "San Juan Atitán"));
                department.addTownship(new township(212, "Santa Eulalia"));
                department.addTownship(new township(213, "San Mateo Ixtatán"));
                department.addTownship(new township(214, "Colotenango"));
                department.addTownship(new township(215, "San Sebastián Huehuetenango"));
                department.addTownship(new township(216, "Tectitán"));
                department.addTownship(new township(217, "Concepción Huista"));
                department.addTownship(new township(218, "San Juan Ixcoy"));
                department.addTownship(new township(219, "San Antonio Huista"));
                department.addTownship(new township(220, "San Sebastián Coatán"));
                department.addTownship(new township(221, "Barillas"));
                department.addTownship(new township(222, "Aguacatán"));
                department.addTownship(new township(223, "San Rafael Petzal"));
                department.addTownship(new township(224, "San Gaspar Ixchil"));
                department.addTownship(new township(225, "Santiago Chimaltenango"));
                department.addTownship(new township(226, "Santa Ana Huista"));
                department.addTownship(new township(227, "Unión Cantinil"));
                break;
            case 14:
                department.addTownship(new township(228, "Santa Cruz del Quiché"));
                department.addTownship(new township(229, "Chiché"));
                department.addTownship(new township(230, "Chinique"));
                department.addTownship(new township(231, "Zacualpa"));
                department.addTownship(new township(232, "Chajul"));
                department.addTownship(new township(233, "Chichicastenango"));
                department.addTownship(new township(234, "Patzité"));
                department.addTownship(new township(235, "San Antonio Ilotenango"));
                department.addTownship(new township(236, "San Pedro Jocopilas"));
                department.addTownship(new township(237, "Cunén"));
                department.addTownship(new township(238, "San Juan Cotzal"));
                department.addTownship(new township(239, "Joyabaj"));
                department.addTownship(new township(240, "Nebaj"));
                department.addTownship(new township(241, "San Andrés Sajcabajá"));
                department.addTownship(new township(242, "Uspantán"));
                department.addTownship(new township(243, "Sacapulas"));
                department.addTownship(new township(244, "San Bartolomé Jocotenango"));
                department.addTownship(new township(245, "Canillá"));
                department.addTownship(new township(246, "Chicamán"));
                department.addTownship(new township(247, "Ixcán"));
                department.addTownship(new township(248, "Pachalum"));
                break;
            case 15:
                department.addTownship(new township(249,"Salamá"));
                department.addTownship(new township(250,"San Miguel Chicaj"));
                department.addTownship(new township(251,"Rabinal"));
                department.addTownship(new township(252,"Cubulco"));
                department.addTownship(new township(253,"Granados"));
                department.addTownship(new township(254,"El Chol"));
                department.addTownship(new township(255,"San Jerónimo"));
                department.addTownship(new township(256,"Purulhá"));
                break;
            case 16:
                department.addTownship(new township(257,"Cobán"));
                department.addTownship(new township(258,"Santa Cruz Verapaz"));
                department.addTownship(new township(259,"San Cristóbal Verapaz"));
                department.addTownship(new township(260,"Tactic"));
                department.addTownship(new township(261,"Tamahú"));
                department.addTownship(new township(262,"Tucurú"));
                department.addTownship(new township(263,"Panzós"));
                department.addTownship(new township(264,"Senahú"));
                department.addTownship(new township(265,"San Pedro Carchá"));
                department.addTownship(new township(266,"San Juan Chamelco"));
                department.addTownship(new township(267,"Lanquín"));
                department.addTownship(new township(268,"Cahabón"));
                department.addTownship(new township(269,"Chisec"));
                department.addTownship(new township(270,"Chahal"));
                department.addTownship(new township(271,"Fray Bartolomé de las Casas"));
                department.addTownship(new township(272,"Santa Catalina la Tinta"));
                department.addTownship(new township(273,"Raxruhá"));
                break;
            case 17:
                department.addTownship(new township(274,"Flores"));
                department.addTownship(new township(275,"San José"));
                department.addTownship(new township(276,"San Benito"));
                department.addTownship(new township(277,"San Andrés"));
                department.addTownship(new township(278,"La Libertad"));
                department.addTownship(new township(279,"San Francisco"));
                department.addTownship(new township(280,"Santa Ana"));
                department.addTownship(new township(281,"Dolores"));
                department.addTownship(new township(282,"San Luis"));
                department.addTownship(new township(283,"Sayaxché"));
                department.addTownship(new township(284,"Melchor de Mencos"));
                department.addTownship(new township(285,"Poptún"));
                department.addTownship(new township(286,"Las Cruces"));
                department.addTownship(new township(287,"El Chal"));
                break;
            case 18:
                department.addTownship(new township(288,"Puerto Barrios"));
                department.addTownship(new township(289,"Livingston"));
                department.addTownship(new township(290,"El Estor"));
                department.addTownship(new township(291,"Morales"));
                department.addTownship(new township(292,"Los Amates"));
                break;
            case 19:
                department.addTownship(new township(293,"Zacapa"));
                department.addTownship(new township(294,"Estanzuela"));
                department.addTownship(new township(295,"Río Hondo"));
                department.addTownship(new township(296,"Gualán"));
                department.addTownship(new township(297,"Teculután"));
                department.addTownship(new township(298,"Usumatlán"));
                department.addTownship(new township(299,"Cabañas"));
                department.addTownship(new township(300,"San Diego"));
                department.addTownship(new township(301,"La Unión"));
                department.addTownship(new township(302,"Huité"));
                department.addTownship(new township(303,"San Jorge"));
                break;
            case 20:
                department.addTownship(new township(304,"Chiquimula"));
                department.addTownship(new township(305,"San José La Arada"));
                department.addTownship(new township(306,"San Juan Ermita"));
                department.addTownship(new township(307,"Jocotán"));
                department.addTownship(new township(308,"Camotán"));
                department.addTownship(new township(309,"Olopa"));
                department.addTownship(new township(310,"Esquipulas"));
                department.addTownship(new township(311,"Concepción Las Minas"));
                department.addTownship(new township(312,"Quetzaltepeque"));
                department.addTownship(new township(313,"San Jacinto"));
                department.addTownship(new township(314,"Ipala"));
                break;
            case 21:
                department.addTownship(new township(315,"Jalapa"));
                department.addTownship(new township(316,"San Pedro Pinula"));
                department.addTownship(new township(317,"San Luis Jilotepeque"));
                department.addTownship(new township(318,"San Manuel Chaparrón"));
                department.addTownship(new township(319,"San Carlos Alzatate"));
                department.addTownship(new township(320,"Monjas"));
                department.addTownship(new township(321,"Mataquescuintla"));
                break;
            case 22:
                department.addTownship(new township(322,"Jutiapa"));
                department.addTownship(new township(323,"El Progreso"));
                department.addTownship(new township(324,"Santa Catarina Mita"));
                department.addTownship(new township(325,"Agua Blanca"));
                department.addTownship(new township(326,"Asunción Mita"));
                department.addTownship(new township(327,"Yupiltepeque"));
                department.addTownship(new township(328,"Atescatempa"));
                department.addTownship(new township(329,"Jerez"));
                department.addTownship(new township(330,"El Adelanto"));
                department.addTownship(new township(331,"Zapotitlán"));
                department.addTownship(new township(332,"Comapa"));
                department.addTownship(new township(333,"Jalpatagua"));
                department.addTownship(new township(334,"Conguaco"));
                department.addTownship(new township(335,"Moyuta"));
                department.addTownship(new township(336,"Pasaco"));
                department.addTownship(new township(337,"San José Acatempa"));
                department.addTownship(new township(338,"Quesada"));
                break;
        }
    }

    public List<site> getStieTypes(){
        List<site> siteList = new ArrayList<>();

        siteList.add(new site(1,"Lago"));
        siteList.add(new site(2,"Rio"));
        siteList.add(new site(3,"Sitio Arqueologico"));
        siteList.add(new site(4,"Mirador"));
        siteList.add(new site(5,"Museo"));
        siteList.add(new site(6,"Valneario"));
        siteList.add(new site(7,"Comercio"));
        siteList.add(new site(8,"Volcan"));
        siteList.add(new site(9,"Montaña"));
        siteList.add(new site(10,"Otro"));

        return siteList;
    }

}
