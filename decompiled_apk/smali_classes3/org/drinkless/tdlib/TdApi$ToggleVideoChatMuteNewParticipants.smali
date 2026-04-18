.class public Lorg/drinkless/tdlib/TdApi$ToggleVideoChatMuteNewParticipants;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleVideoChatMuteNewParticipants"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ad4c98c


# instance fields
.field public groupCallId:I

.field public muteNewParticipants:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33569
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33559
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleVideoChatMuteNewParticipants;->groupCallId:I

    .line 33560
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleVideoChatMuteNewParticipants;->muteNewParticipants:Z

    .line 33561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33565
    const v0, 0x3ad4c98c

    return v0
.end method
