import { Address } from "cluster";
import { PersonSkill } from "./PersonSkill";

export interface Person{
    id :number;
    firstName :string;
    lastName :string;
    address :Address;
    personSkills :PersonSkill[];
}