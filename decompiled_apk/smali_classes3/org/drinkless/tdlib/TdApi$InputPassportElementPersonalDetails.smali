.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementPersonalDetails;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementPersonalDetails"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9d2843f


# instance fields
.field public personalDetails:Lorg/drinkless/tdlib/TdApi$PersonalDetails;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15072
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15073
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDetails;)V
    .locals 0
    .param p1, "personalDetails"    # Lorg/drinkless/tdlib/TdApi$PersonalDetails;

    .line 15063
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15064
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementPersonalDetails;->personalDetails:Lorg/drinkless/tdlib/TdApi$PersonalDetails;

    .line 15065
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15069
    const v0, 0x9d2843f

    return v0
.end method
