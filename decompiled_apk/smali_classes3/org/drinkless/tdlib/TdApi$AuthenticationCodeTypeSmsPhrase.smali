.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSmsPhrase;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeSmsPhrase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2ebc8cd1


# instance fields
.field public firstWord:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8880
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8881
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 8871
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 8872
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeSmsPhrase;->firstWord:Ljava/lang/String;

    .line 8873
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8877
    const v0, 0x2ebc8cd1

    return v0
.end method
