.class public Lorg/drinkless/tdlib/TdApi$FactCheck;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FactCheck"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3e7a06e8


# instance fields
.field public countryCode:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25485
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "str"    # Ljava/lang/String;

    .line 25474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25475
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FactCheck;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 25476
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FactCheck;->countryCode:Ljava/lang/String;

    .line 25477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25481
    const v0, -0x3e7a06e8

    return v0
.end method
