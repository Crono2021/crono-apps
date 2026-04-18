.class public Lorg/drinkless/tdlib/TdApi$AccountInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AccountInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6b7f1d67


# instance fields
.field public lastNameChangeDate:I

.field public lastPhotoChangeDate:I

.field public phoneNumberCountryCode:Ljava/lang/String;

.field public registrationMonth:I

.field public registrationYear:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46475
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i11"    # I
    .param p5, "i12"    # I

    .line 46461
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46462
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AccountInfo;->registrationMonth:I

    .line 46463
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AccountInfo;->registrationYear:I

    .line 46464
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AccountInfo;->phoneNumberCountryCode:Ljava/lang/String;

    .line 46465
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$AccountInfo;->lastNameChangeDate:I

    .line 46466
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$AccountInfo;->lastPhotoChangeDate:I

    .line 46467
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46471
    const v0, 0x6b7f1d67

    return v0
.end method
