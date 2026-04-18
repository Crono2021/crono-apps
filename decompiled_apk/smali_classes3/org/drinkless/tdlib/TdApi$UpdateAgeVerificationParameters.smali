.class public Lorg/drinkless/tdlib/TdApi$UpdateAgeVerificationParameters;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAgeVerificationParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f0003b


# instance fields
.field public parameters:Lorg/drinkless/tdlib/TdApi$AgeVerificationParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21512
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21513
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AgeVerificationParameters;)V
    .locals 0
    .param p1, "ageVerificationParameters"    # Lorg/drinkless/tdlib/TdApi$AgeVerificationParameters;

    .line 21503
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21504
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAgeVerificationParameters;->parameters:Lorg/drinkless/tdlib/TdApi$AgeVerificationParameters;

    .line 21505
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21509
    const v0, -0x2f0003b

    return v0
.end method
