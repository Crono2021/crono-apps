.class public Lorg/drinkless/tdlib/TdApi$GetGrossingWebAppBots;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGrossingWebAppBots"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundUsers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6522ce1a


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 26174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26175
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetGrossingWebAppBots;->offset:Ljava/lang/String;

    .line 26176
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetGrossingWebAppBots;->limit:I

    .line 26177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26181
    const v0, 0x6522ce1a

    return v0
.end method
