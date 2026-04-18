.class public Lorg/drinkless/tdlib/TdApi$SetPassportElementErrors;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPassportElementErrors"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a9796c1


# instance fields
.field public errors:[Lorg/drinkless/tdlib/TdApi$InputPassportElementError;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31689
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$InputPassportElementError;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputPassportElementErrorArr"    # [Lorg/drinkless/tdlib/TdApi$InputPassportElementError;

    .line 31678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31679
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetPassportElementErrors;->userId:J

    .line 31680
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetPassportElementErrors;->errors:[Lorg/drinkless/tdlib/TdApi$InputPassportElementError;

    .line 31681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31685
    const v0, -0x7a9796c1

    return v0
.end method
