const form = document.querySelector('form');
const nameInput = document.getElementById('name');
const priceInput = document.getElementById('price');
const quantityInput = document.getElementById('quantity');
const totalInput = document.getElementById('total');
const addButton = document.querySelector('button[type="submit"]');
const tableBody = document.querySelector('table tbody');
const grandTotalCell = document.querySelector('table tfoot td:last-child');
let itemCount = 0;
let grandTotal = 0;
form.addEventListener('submit', (event) => {
  event.preventDefault();
  const name = nameInput.value.trim();
  const price = parseFloat(priceInput.value.trim());
  const quantity = parseInt(quantityInput.value.trim());
  if (!name || isNaN(price) || isNaN(quantity) || price <= 0 || quantity <= 0) {
    alert('Please enter a valid name, price, and quantity.');
    return;
  }
  const itemTotal = price * quantity;
  grandTotal += itemTotal;
  const newRow = document.createElement('tr');
  itemCount++;
  newRow.innerHTML = `
    <td><button class="delete-button">X</button></td>
    <td>${name}</td>
    <td>${price.toFixed(2)}</td>
    <td id="rigt">${quantity}</td>
    <td id="total">${itemTotal.toFixed(2)}</td>
  `;
  tableBody.appendChild(newRow);
  grandTotalCell.textContent = ` ${grandTotal.toFixed(2)}`;
  nameInput.value = '';
  priceInput.value = '';
  quantityInput.value = '';
  totalInput.value = '';
});
tableBody.addEventListener('click', (event) => {
  if (event.target.classList.contains('delete-button')) {
    const row = event.target.closest('tr');
    const rowTotal = parseFloat(row.querySelector('#total').textContent);
    grandTotal -= rowTotal;
    grandTotalCell.textContent = ` ${grandTotal.toFixed(2)}`;
    row.remove();
  }
});
quantityInput.addEventListener('input', () => {
  const price = parseFloat(priceInput.value.trim());
  const quantity = parseInt(quantityInput.value.trim());
  if (!isNaN(price) && !isNaN(quantity) && price > 0 && quantity > 0) {
    totalInput.value = (price * quantity).toFixed(2);
  } else {
    totalInput.value = '';
  }
});