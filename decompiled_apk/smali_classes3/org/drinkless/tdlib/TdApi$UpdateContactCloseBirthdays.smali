.class public Lorg/drinkless/tdlib/TdApi$UpdateContactCloseBirthdays;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateContactCloseBirthdays"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2256fc1


# instance fields
.field public closeBirthdayUsers:[Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21656
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21657
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;)V
    .locals 0
    .param p1, "closeBirthdayUserArr"    # [Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;

    .line 21647
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21648
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateContactCloseBirthdays;->closeBirthdayUsers:[Lorg/drinkless/tdlib/TdApi$CloseBirthdayUser;

    .line 21649
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21653
    const v0, -0x2256fc1

    return v0
.end method
