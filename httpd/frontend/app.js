async function main() {
  const status = document.getElementById('status');
  const list = document.getElementById('list');
  try {
    const res = await fetch('/api/students', { headers: { 'Accept': 'application/json' }});
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const data = await res.json();
    status.textContent = `Loaded ${data.length} students`;
    list.innerHTML = data.map(s => `<li>${s.firstName} ${s.lastName} (id: ${s.id})</li>`).join('');
  } catch (e) {
    status.classList.add('error');
    status.textContent = `Error: ${e.message}`;
  }
}

window.addEventListener('DOMContentLoaded', main);


