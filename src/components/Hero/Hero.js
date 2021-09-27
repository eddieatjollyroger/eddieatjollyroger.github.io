import React from 'react';

import { Section, SectionText, SectionTitle } from '../../styles/GlobalComponents';
import Button from '../../styles/GlobalComponents/Button';
import { LeftSection } from './HeroStyles';

const Hero = (props) => (
  <>
    <Section row nopadding>
      <LeftSection>
        <SectionTitle main center>
          João Pacheco's <br />
          Personal Webpage
        </SectionTitle>
        <SectionText>
         Welcome to my very own simple Webpage, here you'll find my projects and some information about them and of course, about me!
        </SectionText>
        <Button onClick={props.handleClick}><span class="lookNice">Right click me!</span></Button>
      </LeftSection>
    </Section>
  </>
);

export default Hero;