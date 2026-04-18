.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGame;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xf8b5233


# instance fields
.field public botUsername:Ljava/lang/String;

.field public gameShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27665
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 27654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27655
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGame;->botUsername:Ljava/lang/String;

    .line 27656
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeGame;->gameShortName:Ljava/lang/String;

    .line 27657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27661
    const v0, -0xf8b5233

    return v0
.end method
