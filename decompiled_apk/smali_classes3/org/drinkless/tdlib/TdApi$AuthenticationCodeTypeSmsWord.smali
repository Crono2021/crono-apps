.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSmsWord;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeSmsWord"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59f9c39d


# instance fields
.field public firstLetter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8899
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 8889
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8890
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSmsWord;->firstLetter:Ljava/lang/String;

    .line 8891
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8895
    const v0, -0x59f9c39d

    return v0
.end method
