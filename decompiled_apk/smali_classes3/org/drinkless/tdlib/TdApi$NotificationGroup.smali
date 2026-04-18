.class public Lorg/drinkless/tdlib/TdApi$NotificationGroup;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e886855


# instance fields
.field public chatId:J

.field public id:I

.field public notifications:[Lorg/drinkless/tdlib/TdApi$Notification;

.field public totalCount:I

.field public type:Lorg/drinkless/tdlib/TdApi$NotificationGroupType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48242
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48243
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$NotificationGroupType;JI[Lorg/drinkless/tdlib/TdApi$Notification;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "notificationGroupType"    # Lorg/drinkless/tdlib/TdApi$NotificationGroupType;
    .param p3, "j5"    # J
    .param p5, "i10"    # I
    .param p6, "notificationArr"    # [Lorg/drinkless/tdlib/TdApi$Notification;

    .line 48229
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48230
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$NotificationGroup;->id:I

    .line 48231
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$NotificationGroup;->type:Lorg/drinkless/tdlib/TdApi$NotificationGroupType;

    .line 48232
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$NotificationGroup;->chatId:J

    .line 48233
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$NotificationGroup;->totalCount:I

    .line 48234
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$NotificationGroup;->notifications:[Lorg/drinkless/tdlib/TdApi$Notification;

    .line 48235
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48239
    const v0, 0x2e886855

    return v0
.end method
