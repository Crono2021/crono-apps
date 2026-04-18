.class public Lorg/drinkless/tdlib/TdApi$PassportElementPersonalDetails;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementPersonalDetails"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4894fe83


# instance fields
.field public personalDetails:Lorg/drinkless/tdlib/TdApi$PersonalDetails;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17575
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDetails;)V
    .locals 0
    .param p1, "personalDetails"    # Lorg/drinkless/tdlib/TdApi$PersonalDetails;

    .line 17565
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17566
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementPersonalDetails;->personalDetails:Lorg/drinkless/tdlib/TdApi$PersonalDetails;

    .line 17567
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17571
    const v0, 0x4894fe83

    return v0
.end method
