.class public Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessGreetingMessageSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x64ae3e12


# instance fields
.field public inactivityDays:I

.field public recipients:Lorg/drinkless/tdlib/TdApi$BusinessRecipients;

.field public shortcutId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35882
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35883
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$BusinessRecipients;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "businessRecipients"    # Lorg/drinkless/tdlib/TdApi$BusinessRecipients;
    .param p3, "i10"    # I

    .line 35871
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35872
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;->shortcutId:I

    .line 35873
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;->recipients:Lorg/drinkless/tdlib/TdApi$BusinessRecipients;

    .line 35874
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;->inactivityDays:I

    .line 35875
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35879
    const v0, 0x64ae3e12

    return v0
.end method
