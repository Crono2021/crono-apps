.class public Lorg/drinkless/tdlib/TdApi$SetBotInfoShortDescription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBotInfoShortDescription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a96bae3


# instance fields
.field public botUserId:J

.field public languageCode:Ljava/lang/String;

.field public shortDescription:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40086
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40087
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 40075
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40076
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoShortDescription;->botUserId:J

    .line 40077
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoShortDescription;->languageCode:Ljava/lang/String;

    .line 40078
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoShortDescription;->shortDescription:Ljava/lang/String;

    .line 40079
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40083
    const v0, 0x3a96bae3

    return v0
.end method
