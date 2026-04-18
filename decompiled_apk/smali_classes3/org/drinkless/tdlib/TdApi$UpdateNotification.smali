.class public Lorg/drinkless/tdlib/TdApi$UpdateNotification;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNotification"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7119812c


# instance fields
.field public notification:Lorg/drinkless/tdlib/TdApi$Notification;

.field public notificationGroupId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34729
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$Notification;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "notification"    # Lorg/drinkless/tdlib/TdApi$Notification;

    .line 34718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34719
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotification;->notificationGroupId:I

    .line 34720
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotification;->notification:Lorg/drinkless/tdlib/TdApi$Notification;

    .line 34721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34725
    const v0, -0x7119812c

    return v0
.end method
