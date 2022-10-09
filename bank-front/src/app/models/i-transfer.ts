export interface IOperation {
  accountId: number;
  amount: number;
  description?: string;
}

export interface ITransfer {
  accountSource: number;
  accountDestination: number;
  amount: number;

}
