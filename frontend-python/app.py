
from flask import Flask, render_template, request, redirect, url_for, flash
from services import player_service, coach_service, batch_service

app = Flask(__name__)
app.secret_key = "change-me"


@app.route("/")
def home():
    # just render the landing page with quotes + images
    return render_template("home.html")


# ---------- Players ----------

@app.route("/players")
def players_list():
    players = player_service.list_players()
    return render_template("players/list.html", players=players)

@app.route("/players/new", methods=["GET", "POST"])
def players_new():
    if request.method == "POST":
        data = {
            "fullName": request.form["fullName"],
            "age": int(request.form["age"] or 0),
            "role": request.form["role"],
            "battingStyle": request.form.get("battingStyle"),
            "bowlingStyle": request.form.get("bowlingStyle"),
            "batch": None,
        }
        player_service.create_player(data)
        flash("Player created successfully")
        return redirect(url_for("players_list"))
    return render_template("players/form.html", player=None)

@app.route("/players/<int:player_id>/edit", methods=["GET", "POST"])
def players_edit(player_id):
    if request.method == "POST":
        data = {
            "fullName": request.form["fullName"],
            "age": int(request.form["age"] or 0),
            "role": request.form["role"],
            "battingStyle": request.form.get("battingStyle"),
            "bowlingStyle": request.form.get("bowlingStyle"),
            "batch": None,
        }
        player_service.update_player(player_id, data)
        flash("Player updated successfully")
        return redirect(url_for("players_list"))
    player = player_service.get_player(player_id)
    return render_template("players/form.html", player=player)

@app.route("/players/<int:player_id>/delete", methods=["POST"])
def players_delete(player_id):
    player_service.delete_player(player_id)
    flash("Player deleted")
    return redirect(url_for("players_list"))

# ---------- Coaches ----------

@app.route("/coaches")
def coaches_list():
    coaches = coach_service.list_coaches()
    return render_template("coaches/list.html", coaches=coaches)

@app.route("/coaches/new", methods=["GET", "POST"])
def coaches_new():
    if request.method == "POST":
        data = {
            "fullName": request.form["fullName"],
            "specialty": request.form.get("specialty"),
            "experienceYears": int(request.form.get("experienceYears") or 0),
        }
        coach_service.create_coach(data)
        flash("Coach created successfully")
        return redirect(url_for("coaches_list"))
    return render_template("coaches/form.html", coach=None)

@app.route("/coaches/<int:coach_id>/edit", methods=["GET", "POST"])
def coaches_edit(coach_id):
    if request.method == "POST":
        data = {
            "fullName": request.form["fullName"],
            "specialty": request.form.get("specialty"),
            "experienceYears": int(request.form.get("experienceYears") or 0),
        }
        coach_service.update_coach(coach_id, data)
        flash("Coach updated successfully")
        return redirect(url_for("coaches_list"))
    coach = coach_service.get_coach(coach_id)
    return render_template("coaches/form.html", coach=coach)

@app.route("/coaches/<int:coach_id>/delete", methods=["POST"])
def coaches_delete(coach_id):
    coach_service.delete_coach(coach_id)
    flash("Coach deleted")
    return redirect(url_for("coaches_list"))

# ---------- Batches ----------

@app.route("/batches")
def batches_list():
    batches = batch_service.list_batches()
    return render_template("batches/list.html", batches=batches)

@app.route("/batches/new", methods=["GET", "POST"])
def batches_new():
    if request.method == "POST":
        data = {
            "name": request.form["name"],
            "level": request.form.get("level"),
            "startTime": request.form.get("startTime"),
            "endTime": request.form.get("endTime"),
        }
        batch_service.create_batch(data)
        flash("Batch created successfully")
        return redirect(url_for("batches_list"))
    return render_template("batches/form.html", batch=None)

@app.route("/batches/<int:batch_id>/edit", methods=["GET", "POST"])
def batches_edit(batch_id):
    if request.method == "POST":
        data = {
            "name": request.form["name"],
            "level": request.form.get("level"),
            "startTime": request.form.get("startTime"),
            "endTime": request.form.get("endTime"),
        }
        batch_service.update_batch(batch_id, data)
        flash("Batch updated successfully")
        return redirect(url_for("batches_list"))
    batch = batch_service.get_batch(batch_id)
    return render_template("batches/form.html", batch=batch)

@app.route("/batches/<int:batch_id>/delete", methods=["POST"])
def batches_delete(batch_id):
    batch_service.delete_batch(batch_id)
    flash("Batch deleted")
    return redirect(url_for("batches_list"))


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
