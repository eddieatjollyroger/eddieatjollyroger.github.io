import React from 'react';

import { Section, SectionDivider, SectionTitle } from '../../styles/GlobalComponents';
import { Box, Boxes, BoxNum, BoxText } from './CurriculumStyles';


const Curriculum = () => (
  <Section id="curriculum">
    <SectionTitle>Curriculum Vitae</SectionTitle>
    <iframe src="/my-webpage/images/joaopachecocv_compressed.pdf" width="100%" height="1465px"></iframe>
    <SectionDivider/>
  </Section>
);

export default Curriculum;
