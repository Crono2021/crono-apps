.class public Lorg/drinkless/tdlib/TdApi$SetBotInfoDescription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBotInfoDescription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29571d48


# instance fields
.field public botUserId:J

.field public description:Ljava/lang/String;

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40065
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 40053
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40054
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoDescription;->botUserId:J

    .line 40055
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoDescription;->languageCode:Ljava/lang/String;

    .line 40056
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetBotInfoDescription;->description:Ljava/lang/String;

    .line 40057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40061
    const v0, 0x29571d48

    return v0
.end method
