.class public Lorg/drinkless/tdlib/TdApi$BotCommand;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommand"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3d853739


# instance fields
.field public command:Ljava/lang/String;

.field public description:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 23174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23175
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BotCommand;->command:Ljava/lang/String;

    .line 23176
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BotCommand;->description:Ljava/lang/String;

    .line 23177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23181
    const v0, -0x3d853739

    return v0
.end method
