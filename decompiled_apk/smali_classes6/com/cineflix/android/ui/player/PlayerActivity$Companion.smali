.class public final Lcom/cineflix/android/ui/player/PlayerActivity$Companion;
.super Ljava/lang/Object;
.source "PlayerActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/ui/player/PlayerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002JB\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"
    }
    d2 = {
        "Lcom/cineflix/android/ui/player/PlayerActivity$Companion;",
        "",
        "()V",
        "EXTRA_CHAT_ID",
        "",
        "EXTRA_FILE_ID",
        "EXTRA_FILE_SIZE",
        "EXTRA_MIME_TYPE",
        "EXTRA_MSG_ID",
        "EXTRA_TITLE",
        "TAG",
        "start",
        "",
        "context",
        "Landroid/content/Context;",
        "fileId",
        "",
        "chatId",
        "",
        "msgId",
        "fileSize",
        "mimeType",
        "title",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lcom/cineflix/android/ui/player/PlayerActivity$Companion;-><init>()V

    return-void
.end method

.method public static synthetic start$default(Lcom/cineflix/android/ui/player/PlayerActivity$Companion;Landroid/content/Context;IJJJLjava/lang/String;Ljava/lang/String;ILjava/lang/Object;)V
    .locals 13

    .line 41
    and-int/lit8 v0, p11, 0x10

    if-eqz v0, :cond_0

    .line 46
    const-wide/16 v0, 0x0

    move-wide v9, v0

    goto :goto_0

    .line 41
    :cond_0
    move-wide/from16 v9, p7

    :goto_0
    and-int/lit8 v0, p11, 0x20

    if-eqz v0, :cond_1

    .line 47
    const-string v0, "video/mp4"

    move-object v11, v0

    goto :goto_1

    .line 41
    :cond_1
    move-object/from16 v11, p9

    :goto_1
    move-object v2, p0

    move-object v3, p1

    move v4, p2

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-object/from16 v12, p10

    invoke-virtual/range {v2 .. v12}, Lcom/cineflix/android/ui/player/PlayerActivity$Companion;->start(Landroid/content/Context;IJJJLjava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public final start(Landroid/content/Context;IJJJLjava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "fileId"    # I
    .param p3, "chatId"    # J
    .param p5, "msgId"    # J
    .param p7, "fileSize"    # J
    .param p9, "mimeType"    # Ljava/lang/String;
    .param p10, "title"    # Ljava/lang/String;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "mimeType"

    invoke-static {p9, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "title"

    invoke-static {p10, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 50
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/cineflix/android/ui/player/PlayerActivity;

    invoke-direct {v1, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object v2, v1

    .local v2, "$this$start_u24lambda_u240":Landroid/content/Intent;
    const/4 v3, 0x0

    .line 51
    .local v3, "$i$a$-apply-PlayerActivity$Companion$start$1":I
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 52
    const-string v4, "file_id"

    invoke-virtual {v2, v4, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 53
    const-string v4, "chat_id"

    invoke-virtual {v2, v4, p3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 54
    const-string v4, "msg_id"

    invoke-virtual {v2, v4, p5, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 55
    const-string v4, "file_size"

    invoke-virtual {v2, v4, p7, p8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 56
    const-string v4, "mime_type"

    invoke-virtual {v2, v4, p9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 57
    invoke-virtual {v2, v0, p10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 58
    nop

    .line 50
    .end local v2    # "$this$start_u24lambda_u240":Landroid/content/Intent;
    .end local v3    # "$i$a$-apply-PlayerActivity$Companion$start$1":I
    invoke-virtual {p1, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 59
    return-void
.end method
