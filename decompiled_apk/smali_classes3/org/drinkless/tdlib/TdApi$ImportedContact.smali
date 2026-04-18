.class public Lorg/drinkless/tdlib/TdApi$ImportedContact;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImportedContact"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6c5fab84


# instance fields
.field public firstName:Ljava/lang/String;

.field public lastName:Ljava/lang/String;

.field public note:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43735
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43722
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43723
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ImportedContact;->phoneNumber:Ljava/lang/String;

    .line 43724
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ImportedContact;->firstName:Ljava/lang/String;

    .line 43725
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ImportedContact;->lastName:Ljava/lang/String;

    .line 43726
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ImportedContact;->note:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43727
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43731
    const v0, 0x6c5fab84

    return v0
.end method
