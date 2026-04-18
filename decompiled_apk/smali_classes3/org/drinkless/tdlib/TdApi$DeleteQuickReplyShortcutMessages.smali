.class public Lorg/drinkless/tdlib/TdApi$DeleteQuickReplyShortcutMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteQuickReplyShortcutMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x26a54c3


# instance fields
.field public messageIds:[J

.field public shortcutId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25145
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 25134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25135
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteQuickReplyShortcutMessages;->shortcutId:I

    .line 25136
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteQuickReplyShortcutMessages;->messageIds:[J

    .line 25137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25141
    const v0, -0x26a54c3

    return v0
.end method
