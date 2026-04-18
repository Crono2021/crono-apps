.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsMuted;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallParticipantIsMuted"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4df7ebf9


# instance fields
.field public groupCallId:I

.field public isMuted:Z

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41186
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41187
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$MessageSender;Z)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "z8"    # Z

    .line 41175
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41176
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsMuted;->groupCallId:I

    .line 41177
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsMuted;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 41178
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsMuted;->isMuted:Z

    .line 41179
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41183
    const v0, -0x4df7ebf9

    return v0
.end method
