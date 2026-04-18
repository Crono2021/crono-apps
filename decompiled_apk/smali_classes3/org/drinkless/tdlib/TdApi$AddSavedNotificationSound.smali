.class public Lorg/drinkless/tdlib/TdApi$AddSavedNotificationSound;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddSavedNotificationSound"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$NotificationSound;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e3984ef


# instance fields
.field public sound:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8719
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 8709
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8710
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddSavedNotificationSound;->sound:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 8711
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8715
    const v0, 0x3e3984ef

    return v0
.end method
