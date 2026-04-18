.class public Lorg/drinkless/tdlib/TdApi$PassportElementPhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementPhoneNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4eaf6867


# instance fields
.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17592
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17593
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17583
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17584
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementPhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 17585
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17589
    const v0, -0x4eaf6867

    return v0
.end method
