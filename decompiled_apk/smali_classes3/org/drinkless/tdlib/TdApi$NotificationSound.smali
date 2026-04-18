.class public Lorg/drinkless/tdlib/TdApi$NotificationSound;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationSound"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb109ec9


# instance fields
.field public data:Ljava/lang/String;

.field public date:I

.field public duration:I

.field public id:J

.field public sound:Lorg/drinkless/tdlib/TdApi$File;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50290
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50291
    return-void
.end method

.method public constructor <init>(JIILjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 50276
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50277
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->id:J

    .line 50278
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->duration:I

    .line 50279
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->date:I

    .line 50280
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->title:Ljava/lang/String;

    .line 50281
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->data:Ljava/lang/String;

    .line 50282
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$NotificationSound;->sound:Lorg/drinkless/tdlib/TdApi$File;

    .line 50283
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50287
    const v0, -0xb109ec9

    return v0
.end method
