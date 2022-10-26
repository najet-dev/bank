export interface IUser {
  id: number;
  code: number;
  lastName: string;
  firstName: string;
  username: string;
  password: string
  roles?: [];
  account?: [];
}

