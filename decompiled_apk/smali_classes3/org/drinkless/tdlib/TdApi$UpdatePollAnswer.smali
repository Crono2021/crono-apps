.class public Lorg/drinkless/tdlib/TdApi$UpdatePollAnswer;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdatePollAnswer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41db8403


# instance fields
.field public optionIds:[I

.field public pollId:J

.field public voterId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41869
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "iArr"    # [I

    .line 41857
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41858
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdatePollAnswer;->pollId:J

    .line 41859
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdatePollAnswer;->voterId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 41860
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdatePollAnswer;->optionIds:[I

    .line 41861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41865
    const v0, 0x41db8403

    return v0
.end method
