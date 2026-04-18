.class public Lorg/drinkless/tdlib/TdApi$SetAutoDownloadSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAutoDownloadSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x15149b0c


# instance fields
.field public settings:Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;

.field public type:Lorg/drinkless/tdlib/TdApi$NetworkType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30989
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;Lorg/drinkless/tdlib/TdApi$NetworkType;)V
    .locals 0
    .param p1, "autoDownloadSettings"    # Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;
    .param p2, "networkType"    # Lorg/drinkless/tdlib/TdApi$NetworkType;

    .line 30978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30979
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetAutoDownloadSettings;->settings:Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;

    .line 30980
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetAutoDownloadSettings;->type:Lorg/drinkless/tdlib/TdApi$NetworkType;

    .line 30981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30985
    const v0, -0x15149b0c

    return v0
.end method
