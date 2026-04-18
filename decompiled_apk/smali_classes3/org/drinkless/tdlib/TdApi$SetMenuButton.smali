.class public Lorg/drinkless/tdlib/TdApi$SetMenuButton;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMenuButton"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4bb03ebf


# instance fields
.field public menuButton:Lorg/drinkless/tdlib/TdApi$BotMenuButton;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31588
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31589
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$BotMenuButton;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "botMenuButton"    # Lorg/drinkless/tdlib/TdApi$BotMenuButton;

    .line 31578
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31579
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetMenuButton;->userId:J

    .line 31580
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetMenuButton;->menuButton:Lorg/drinkless/tdlib/TdApi$BotMenuButton;

    .line 31581
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31585
    const v0, -0x4bb03ebf

    return v0
.end method
