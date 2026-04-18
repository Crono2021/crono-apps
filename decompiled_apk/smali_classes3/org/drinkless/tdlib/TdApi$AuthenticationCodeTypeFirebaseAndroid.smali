.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFirebaseAndroid;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeFirebaseAndroid"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f9bb51e


# instance fields
.field public deviceVerificationParameters:Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;

.field public length:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 22965
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;I)V
    .locals 0
    .param p1, "firebaseDeviceVerificationParameters"    # Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;
    .param p2, "i9"    # I

    .line 22954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 22955
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFirebaseAndroid;->deviceVerificationParameters:Lorg/drinkless/tdlib/TdApi$FirebaseDeviceVerificationParameters;

    .line 22956
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFirebaseAndroid;->length:I

    .line 22957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22961
    const v0, 0x6f9bb51e

    return v0
.end method
