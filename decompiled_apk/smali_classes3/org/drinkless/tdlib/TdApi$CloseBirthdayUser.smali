.class public Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CloseBirthdayUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ff9a612


# instance fields
.field public birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24585
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Birthdate;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "birthdate"    # Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 24574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24575
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;->userId:J

    .line 24576
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;->birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 24577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24581
    const v0, -0x7ff9a612

    return v0
.end method
